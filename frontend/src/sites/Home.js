import React, {Component} from 'react';
import '../App.css';
import NavigationBar from "../components/NavigationBar";

class Home extends Component {
    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <NavigationBar/>
                    This is the home page of Workshop
                    <div>Authors:
                        <p>Patryk Krzyżaniak</p>
                        <p>Marcin Chmielowiec</p>
                        <p>Kamil Gronowski</p>
                    </div>
                </header>
            </div>
        );
    }
}

export default Home;