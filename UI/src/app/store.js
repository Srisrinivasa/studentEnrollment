import { createStore, combineReducers, applyMiddleware } from 'redux';
import { logger } from 'redux-logger';
import thunk from 'redux-thunk';
import regdReducer from './reducers/registrationReducer';
import promiseMiddleware from 'redux-promise-middleware';
import loginReducer from './reducers/loginReducer';
import loanReducer from './reducers/loanReducer';
import adminReducer from './reducers/adminReducer';


const store = createStore(combineReducers({ loginReducer, regdReducer, loanReducer, adminReducer }),
 {}, applyMiddleware(logger, thunk, promiseMiddleware()));
export default store;
