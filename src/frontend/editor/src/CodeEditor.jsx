import { useState, useRef ,useEffect} from "react";
import { Link, NavLink, useNavigate, useParams } from 'react-router-dom'
import { Editor } from "@monaco-editor/react";
import Swal from 'sweetalert2';
import Terminal from "./Terminal";

function CodeEditor() {
    const navigate=useNavigate()
    const editorRef = useRef(null);
    const [code, setCode] = useState('');
    const [id, setId] = useState('');
    const [language, setLanguage] = useState('javascript');
    const [output, setOutput] = useState("");
    const [time, setTime] = useState("");
    const{uuid,key}=useParams()
    useEffect(() => {
        if (!uuid || !key) {
          navigate("/");
        }
        else {
          fetch(`http://127.1:8080/api/joinRoom?uuid=${uuid}&roomKey=${key}`, {
                            method: 'GET',
                            headers: {
                            'Content-Type': 'application/json'
                            },
                        }).then(response => {
                            if (response.ok) {
                                return response.json();
                            } else {
                                navigate('/')
                            }
                        })
                            .then(data1 => {
                                
                                setLanguage(data1.lang)
                                setId(data1.id)
                                editorRef.current.setValue(data1.code)

                                console.log(data1)
                                
                            })
        }
      }, [])

    function handleEditorDidMount(editor, monaco) {
        editorRef.current = editor;
    }

    const getEditorValue = () => {
        console.log(editorRef.current.getValue());
    }
    const handleLanguageChange = (event) => {
        setLanguage(event.target.value);
        setCode(''); // Clear the code when language changes
    };

    const runCode = () => {
        let timerInterval;
            Swal.fire({
            title: "Executing",
            background: 'black',
            //html: "executing.",
            timer: 360,
            timerProgressBar: true,
            didOpen: () => {
                Swal.showLoading();
                const timer = Swal.getPopup().querySelector("b");
                timerInterval = setInterval(() => {
                timer.textContent = `${Swal.getTimerLeft()}`;
                }, 100);
            },
            willClose: () => {
                clearInterval(timerInterval);
            }
            }).then((result) => {
            /* Read more about handling dismissals below */
            if (result.dismiss === Swal.DismissReason.timer) {
                console.log("I was closed by the timer");
            }
            });
        // Add your code execution logic here
        var codes = editorRef.current.getValue()
        const obj = { code: codes, lang: language }
        console.log(language)
        setOutput("")
        setTime("")
        fetch('http://127.1:8080/api/exec', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)

        }).then(response => response.json())
            .then(data => {
                setOutput(data.out)
                setTime(data.tte)
            }).catch(console.error())
    };
    const saveCode=()=>{
        fetch('http://127.1:8080/api/saveState', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id:id,lang:language,code:editorRef.current.getValue(),uuid:uuid,roomKey:key})

        }).then(response => {
            if(response.ok){
                Swal.fire({
                    title: "Saved",
                    background:'black',
                    showClass: {
                      popup: `
                        animate__animated
                        animate__fadeInUp
                        animate__faster
                      `
                    },
                    hideClass: {
                      popup: `
                        animate__animated
                        animate__fadeOutDown
                        animate__faster
                      `
                    }
                  });
            }
            else{
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Failed to save code. Please try again later.'
                });
            }
        })
            
    }

    return (
        <>
            <div className="flex justify-between pb-3" style={{backgroundColor:'rgb(22,22,22)'}}>
                <div className="App">
                    <div style={{ marginBottom: '10px' }} className="edits">
                        <select onChange={handleLanguageChange} value={language}>
                            <option value="javascript">JavaScript</option>
                            <option value="python">Python</option>
                            <option value="go">Go</option>
                            <option value="cpp">C++</option>
                            <option value="c">C</option>
                            <option value="java">Java</option>
                            <option value="rust">Rust</option>
                            {/* Add more options for other languages */}
                        </select>
                        <div className="flex w-20%">
                            <button onClick={saveCode} className="w-fit p-1 py-2 h-full text-white bg-green-600 rounded-sm" style={{ marginLeft: '10px' }}>Save</button>
                            <button onClick={runCode} className="w-fit p-1 py-2 h-full text-white bg-green-600 rounded-sm mr-2" style={{ marginLeft: '10px' }}>Run Code</button>
                        </div>
                        
                    </div>
                    <Editor
                        height="95vh"
                        width="50vw"
                        theme="vs-dark"
                        onMount={handleEditorDidMount}
                        language={language} // Set the language dynamically
                    />

                </div>

                <Terminal output={output} time={time} />
            </div>
        </>


    );
}

export default CodeEditor;