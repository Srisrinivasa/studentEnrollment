import React from 'react';
import { connect } from 'react-redux';
import NavBar from '../components/NavigationBar/NavigationBar';

class App extends React.Component {
  render() {
    return (
      <div className="container-fluid no-padding">
        <div className="row no-margin">
          <Header titleName='Loan Management System' />
          {/*<Login />*/}
        </div>
        <div className="row no-margin">
          <div className="col-md-6"></div>
          <div className="col-md-6"></div>
        </div>
      </div>
    );
  }
}

export default App;
