import React from 'react';
import './Header.css';
import myImage from "../../Pages/Logo_GreyBg.PNG";
import {useNavigate} from "react-router-dom"
import Cookies from 'js-cookie';





const Header = ({ userName, crib}) => {
    const navigate = useNavigate();


    const logout = () => {
        navigate("/")
        Cookies.remove("Token", "")


    };
    return (
        <header className="header">

            <img src={myImage} alt="My Image" className="my-image2" />

            <p className={"text"}>Your crib: {crib}</p>
            <p className={"text"} >Logged in as: {userName}</p>

            <p id={"logoutText"} onClick={logout}>logout</p>


        </header>
    );
};

export default Header;