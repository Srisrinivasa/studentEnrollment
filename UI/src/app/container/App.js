import React from 'react';
import { connect } from 'react-redux';
import NavBar from '../components/NavigationBar/NavigationBar';
import { Login } from '../components/Login/Login';
import { updateInput, loginUser } from '../actions/loginActions';
import { bindActionCreators } from 'redux';
import { Header } from '../components/Header/Header';
import RegistrationPage from './RegistrationPage/RegistrationPage';
import EMICalculator from '../components/EMICalculator/EMICalculator';
import './App.css';

class App extends React.Component {
    handleLogin() {
        let data = {
            userId: this.props.loginReducer.userId,
            password: this.props.loginReducer.password,
        }
        this.props.loginUser(data);
    }
    render() {
        return (
            <div className="container-fluid no-padding h100 w100">
                <div className="row no-margin" id='header-section'>
                    <div className="col-md-12">
                        <Header titleName='Loan Management System' />
                    </div>
                </div>
                <div className="row no-margin">
                    <div className="col-md-6">
                        <div className="row no-margin">
                            <Login
                                handleLogin={() => this.handleLogin()}
                                updateInput={this.props.updateInput}
                                loginReducer={this.props.loginReducer}
                            />
                        </div>
                        <div className="row no-margin">
                            <div className="col-md-12 no-padding">
                                <EMICalculator />
                            </div>
                        </div>
                    </div>
                    <div className="col-md-6">
                        <RegistrationPage />
                    </div>
                </div>
            </div>
        );
    }
}
const mapStateToProps = (_state) => {
    let state = _state;
    return {
        loginReducer: state.loginReducer,
    };
};

const mapDispatchToProps = (_dispatch) => {
    let dispatch = _dispatch;
    return bindActionCreators({ updateInput, loginUser }, dispatch);
};

export default connect(mapStateToProps, mapDispatchToProps)(App);