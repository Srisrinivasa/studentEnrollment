import { createStore, combineReducers, applyMiddleware } from 'redux';
import { logger } from 'redux-logger';
import thunk from 'redux-thunk';
import studentReducer from './reducers/studentReducer';
import promiseMiddleware from 'redux-promise-middleware';

const store = createStore(combineReducers({ studentReducer }),
 {}, applyMiddleware(logger, thunk, promiseMiddleware()));
export default store;
