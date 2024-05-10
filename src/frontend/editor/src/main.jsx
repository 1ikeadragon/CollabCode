import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Room from './Room.jsx'
import PopUp from './PopUp.jsx'
import CodeEditor from './CodeEditor.jsx'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import Layout from './Layout.jsx'




const router=createBrowserRouter([
  
  { path:'/',
   element:<Layout/>,
   children:[
    {path:'',
     element:<Room/>},
    {path:'CodeEditor/:uuid/:key',
     element:<CodeEditor/>},
   ]
 }
])

ReactDOM.createRoot(document.getElementById('root')).render(
  
    <RouterProvider router={router}/>
    
)
