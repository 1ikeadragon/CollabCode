import { useState, useRef } from "react";
import logo from "../logo.svg";
import { Editor } from "@monaco-editor/react";
import Terminal from "./Terminal";

function CodeEditor() {
    const editorRef = useRef(null);
    const [code, setCode] = useState('');
    const [language, setLanguage] = useState('javascript');
    const [output, setOutput] = useState("");
    const [time, setTime] = useState("");

    function handleEditorDidMount(editor, monaco){
        editorRef.current = editor;
    }

    const getEditorValue=()=>{
        console.log(editorRef.current.getValue());
    }
    const handleLanguageChange = (event) => {
        setLanguage(event.target.value);
        setCode(''); // Clear the code when language changes
    };

    const runCode = () => {
        // Add your code execution logic here
        var codes=editorRef.current.getValue()
        const obj={code:codes,lang:language}
        console.log(language)
        fetch('http://127.0.0.1:8080/exec', {
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

    return (
        <>
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
                    <button onClick={runCode} style={{ marginLeft: '10px' }} className="runcode">Run Code</button>
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
        </>


    );
}

export default CodeEditor;