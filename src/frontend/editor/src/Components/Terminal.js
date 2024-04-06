import { useState, useRef } from "react"; 

function Terminal() {
    const [input, setInput] = useState("");
    const [output, setOutput] = useState("");
  return (
    <div className="Terminal">
      <div className="output">Output:</div>
    </div>
  );
}

export default Terminal;
