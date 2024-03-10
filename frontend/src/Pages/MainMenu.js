import './Login.css'

import Button from '../Components/Button/Button'
import {Calendar} from 'rsuite';
import 'rsuite/dist/rsuite.min.css';
import "./MainMenu.css"

function MainMenu() {


    return(
        <div className={"mainMenuContainer"}>
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