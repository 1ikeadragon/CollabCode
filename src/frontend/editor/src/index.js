import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Nav from './Components/Nav';
import CodeEditor from './Components/CodeEditor';
import Terminal from './Components/Terminal';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Nav/>
    <div className='sex'>
    <CodeEditor />
    </div>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
