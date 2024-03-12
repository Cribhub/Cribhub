import './Login.css'
import Button from '../Components/Button/Button'
import {Calendar} from 'rsuite';
import 'rsuite/dist/rsuite.min.css';
import "./MainMenu.css"
import Header from '../Components/Header/Header'
import Cookies from 'js-cookie';


function MainMenu() {

    let token = Cookies.get("Token")

    const payload = parseJwt(token);
    let userName = payload.customerName;
    let cribName = payload.customerCribName;

    console.log(userName)


    function parseJwt(token) {
        try {
            const base64Url = token.split('.')[1]; // Get the payload part of the token
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            return JSON.parse(jsonPayload);
        } catch (e) {
            return null;
        }
    }


    return(
        <div className={"mainMenuContainer"}>
            <Header
                userName={userName}
                crib={cribName}
            />
            <div className={"firstrow"}>
                <div id={"taskList"}>
                    <p>TASK LIST</p>
                    <ul>
                        <li>task</li>
                        <li>task</li>
                        <li>task</li>
                    </ul>
                    <Button text={"Add to list"} />


                </div>
                <div id={"shoppingList"}>
                    <p>SHOPPING LIST</p>
                    <ul>
                        <li>item</li>
                        <li>item</li>
                        <li>item</li>
                    </ul>
                    <Button text={"Add to list"} />
                </div>
            </div>

            <div className={"calenderContainer"}></div>
            <Calendar
                bordered={true}
                isoWeek={true}
                compact={true}
            />



        </div>
    )
}

export default MainMenu