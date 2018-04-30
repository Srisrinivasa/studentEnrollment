import React from 'react';
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import store from './store';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import App from './container/App';
import EnrollPage from './container/EnrollPage/EnrollPage';
import UserHome from './container/UserHome/UserHome';
import AdminHome from './container/AdminHome/AdminHome';
import CaptureLoanDetails from './container/CaptureLoanDetails/CaptureLoanDetails';
import KYCApprovals from './container/KYCApprovals/KYCApprovals';
import LoanApprovals from './container/LoanApprovals/LoanApprovals';
import LoanDisbursementDetails from './container/LoanDisbursementDetails/LoanDisbursementDetails';
import './index.css';

render(
    <Provider store={store}>
        <Router history={browserHistory}>
            <Route path="/" component={App} />
            <Route path='/userHome' component={UserHome} >
                <IndexRoute component={CaptureLoanDetails} />
                <Route path="/loanStatus" component={LoanDisbursementDetails} />
            </Route>
            <Route path='/adminHome' component={AdminHome} >
                <IndexRoute component={KYCApprovals} />
                <Route path="/loanApprovals" component={LoanApprovals} />
            </Route>

        </Router>
    </Provider>, window.document.getElementById('app'));
