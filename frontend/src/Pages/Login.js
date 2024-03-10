import './Login.css'
import { NavLink } from 'react-router-dom';
import {useState} from "react";
import { useNavigate } from 'react-router-dom';
import Input from '../Components/TextInput'
import Button from "../Components/Button/Button";


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

    function loginButtonOnclick(){
        navigate('/mainmenu');
    }



    return(
        <div className={"container"}>
        <div className={"logo"}>
            <p className={"text-wrapper-3"}>CRIBHUB</p>
            <p> LOGO </p>
            <p> To help your shared accomadtion needs</p>
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