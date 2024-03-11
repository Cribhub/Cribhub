import './Login.css'

import Input from '../Components/TextInput'
import Button from '../Components/Button/Button'
import {NavLink} from "react-router-dom";
import {useState} from "react";

function CreateAccount() {

    const [emailValue, setEmailValue] = useState('');
    const [usernameValue, setUsernameValue] = useState('');
    const [passwordValue, setPasswordValue] = useState('');
    const [confrimPasswordValue, setConfrimPasswordValue] = useState('');

    const handleEmailChange = (newValue) => {
        setEmailValue(newValue)
    }

    const handleUsernameChange = (newValue) => {
        setUsernameValue(newValue)
    }

    const handlePasswordChange = (newValue) => {
        setPasswordValue(newValue)
    }

    const handleConfrimPasswordChange = (newValue) => {
        setConfrimPasswordValue(newValue)
    }

    function createAccountButton(){
        //TODO
    }

    return(
        <div className={""}>

            <div className={"form"}>
                <p className={"text-wrapper-3"}> Create Account: </p>
                <NavLink to="/" activeClassName="active" className={"text-wrapper-3"}>Already have an account? Login</NavLink>

                <Input
                    type= "email"
                    placeholder={"Email"}
                    value={emailValue}
                    onChange={handleEmailChange}
                    size={"large"}
                />
                <Input
                    type="text"
                    placeholder={"Username"}
                    value={usernameValue}
                    onChange={handleUsernameChange}
                    size={"large"}


                />
                <Input
                    type="password"
                    placeholder={"Password"}
                    value={passwordValue}
                    onChange={handlePasswordChange}
                    size={"large"}

                />
                <Input
                    type= "password"
                    placeholder={"Confirm Password"}
                    value={confrimPasswordValue}
                    onChange={handleConfrimPasswordChange}
                    size={"large"}
                />

                <Button
                    text={"CREATE ACCOUNT"}
                    onClick={createAccountButton}
                />
            </div>


        </div>
    )
}

export default CreateAccount