import React, { useState, useEffect ,useContext} from 'react';
import { Outlet } from 'react-router-dom';


    
function Layout(){
    let x=window.location.href.toLowerCase()
        return(
            <>
                <Outlet/>    
            </>
            )  
    }   
    


export default Layout