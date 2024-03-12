import './Login.css'
import { NavLink } from 'react-router-dom';
import {useState} from "react";
import { useNavigate } from 'react-router-dom';
import Input from '../Components/TextInput'
import Button from "../Components/Button/Button";
import myImage from "./Logo_GreyBg.PNG"
import axios from "axios";
import Cookies from 'js-cookie';


function Login(){
    let navigate = useNavigate();
    const [emailValue, setEmailValue] = useState('');
    const [passwordValue, setPasswordValue] = useState('');


    const handleEmailChange = (newValue) => {
        setEmailValue(newValue)
    }

    const handlePasswordChange = (newValue) => {
        setPasswordValue(newValue)
    }

    let loginData = {
        "email" : emailValue,
        "password" : passwordValue
    }

    function loginButtonOnclick(){
        axios.post("http://localhost:8080/login", loginData).then(
            function (response){
                Cookies.set('Token', response.data.token);
                console.log(response.data.token)
                navigate('/mainmenu');
            }
        ).catch(function (error){ console.log(error)})
    }





    return(
        <div className={"container"}>
        <div className={"logo"}>
            <div>
                <img src={myImage} alt="My Image" className={"my-image"} />
            </div>
        </div>

        <div className="form">
            <div className="text-wrapper-3">LOG IN</div>
            <div className="span">
                <div className="text-wrapper-4">
                    <NavLink to="/createaccount" activeClassName="active">New user? Create account</NavLink>
                </div>

            </div>
            <Input
                type="email"
                placeholder="your email"
                value={emailValue}
                onChange={handleEmailChange}
                size={"large"}
                shape={"square"}
            />
            <Input
                type="password"
                placeholder="your password"
                value={passwordValue}
                onChange={handlePasswordChange}
                size="large"
                shape="square"
            />

            <Button
                text={"SUBMIT"}
                onClick={loginButtonOnclick}
            />
        </div>
        </div>

    )
}

export default Login