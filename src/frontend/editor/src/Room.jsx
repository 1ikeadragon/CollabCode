import React, { useState } from 'react'
import team from './images/team.jpg'
import PopUp from './PopUp';
import { faL } from '@fortawesome/free-solid-svg-icons';



function Room() {

    const [buttonDisabled, setButtonDisabled] = useState(true);
    const [textColor, setTextColor] = useState('text-slate-400');
    const [isOpen, setIsOpen] = useState(false);
    const [isJoin, setIsjoin] = useState(false);
    const [value, setValue] = useState("")

    const handleInputChange = (e) => {
        setValue(e.target.value)
        const value = e.target.value;
        const v = value.trim();

        if (v.length > 0) {
            setButtonDisabled(false);
            setTextColor('text-blue-500');
        }
        else {
            setButtonDisabled(true);
            setTextColor('text-slate-400');
        }
    };

    const joinClick = (e) => {
        setIsjoin(true)
        setIsOpen(true)
        
    }

    const createRoom=(e)=>{
        setValue(crypto.randomUUID())
        setIsOpen(true);
        setIsjoin(false)

        
    }


    return (
        <div className='h-screen w-screen overflow-hidden'>

            <div className='flex justify-between items-center px-5 bg-white w-full h-16 cursor-pointer'>
                <div className='text-2xl font-medium'>CollabCode</div>
                <div className='flex justify-between w-40 text-xl mx-5'>
                    <div>Home</div>
                    <div>About</div>
                </div>
            </div>

            <div className='flex h-full'>

                <div className='h-screen w-3/5 flex flex-col justify-center items-center'>

                    <div className='bg-white h-fit w-10/12'>

                        <div className='text-7xl h-fit my-5'>
                            <p className='my-3'>Collaborative coding platform</p>
                        </div>

                        <div className='text-xl font-normal my-5'>Collaborate and code in 10 languages with just a click, free.</div>

                        <div className='flex justify-start items-center'>

                            <button className='bg-blue-500 h-15 py-3 w-fit px-4 mr-3 text-xl rounded-lg text-white' onClick={createRoom}>Create Room</button>
                            

                            <p className='mr-3 text-xl'>Or</p>

                            <input type="text" placeholder='Enter Room ID' className='border border-blue-500 h-15 p-3 text-xl mr-5 rounded-lg' onChange={handleInputChange} value={value}/>

                            <button disabled={buttonDisabled} className={`font-medium ${textColor}`} onClick={joinClick}>Join</button>
                        </div>
                    </div>
                    {console.log(value)}
                    {isOpen && <PopUp textValue={value} onClose={()=>{setIsOpen(false)}} />}
                    {isOpen && isJoin && <PopUp textValue={value} onClose={()=>{setIsOpen(false)}} />}

                </div>

                <div className='h-screen w-2/5 flex justify-start items-center'>
                    <div className='w-11/12 h-2/4'>
                        <img src={team} className='h-full w-full'/>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Room