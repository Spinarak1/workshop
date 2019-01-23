import React, {Component} from 'react';
import NavigationBar from "../components/NavigationBar";
import logo from "../logo.svg";

class Services extends Component {
    render() {
        return (
            <div className="Actions">
                <header className="App-header">
                    <NavigationBar/>
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h3>Services</h3>
                    <p>work in progress</p>
                </header>
            </div>
        );
    }
}

export default Services;
