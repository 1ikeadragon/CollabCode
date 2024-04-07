function Terminal({ output, time }) { // Destructure output from props
    const formattedOutput = output.split('\n').map((line, index) => <div key={index} style={{whiteSpace: 'pre'}}>{line}</div>);

    if (time.length != 0){
        return (
            <div className="Terminal">
                <div className="output">Output:</div>
                {formattedOutput}
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
