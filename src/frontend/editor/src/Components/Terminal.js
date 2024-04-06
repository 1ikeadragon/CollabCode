function Terminal({ output, time }) { // Destructure output from props
    if (time.length != 0){
        return (
            <div className="Terminal">
            <div className="output">Output:</div>
            <div>{output}</div>
            <br /><br /><br /><br /><br /><br />
            <div>Execution completed in {time} seconds.</div> 
            </div>
        );
    }
    else{
        return (
            <div className="Terminal">
            <div className="output">Output:</div>
            </div>
        ); 
    }
}

export default Terminal;
