import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Home from "./sites/Home";
import Actions from "./sites/Actions";
import Clients from "./sites/Clients";
import Services from "./sites/Services";
import ClientsEdit from "./sites/ClientsEdit";
import ActionsEdit from "./sites/ActionsEdit";

class App extends Component {
    render() {
        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/actions' exact={true} component={Actions}/>
                    <Route path='/actions/:id' component={ActionsEdit}/>
                    <Route path='/clients' exact={true} component={Clients}/>
                    <Route path='/clients/:id' component={ClientsEdit}/>
                    <Route path='/services' exact={true} component={Services}/>
                </Switch>
            </Router>
        )
    }
}

export default App;