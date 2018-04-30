import axios from 'axios';
import { browserHistory } from 'react-router';

export function updateInput(event) {
    return dispatch => {
        dispatch({
            type: "LOGIN_UPDATE_INPUT",
            payload: event.target
        })
    }
}

export const loginUser = (data) => {
    return dispatch => {
        return axios({
            method: 'POST',
            url: 'http://10.117.189.233:8080/user',
            data: data,
        })
            .then((response, error) => {
                {
                    if (response.data.role !== '') {
                        debugger;
                        dispatch({
                            type: "LOGIN_SET_VALUE",
                            payload: { id: 'role', val: response.data.role }
                        })
                        if (response.data.role === 'USER') {
                            browserHistory.push('/userHome');
                        }
                        else {
                            browserHistory.push('/adminHome');
                        }
                    }
                    else {
                        debugger;
                        alert(response.data.message);
                    }

                }
            })
    }
}

export function setTrue(param) {
    return dispatch => {
        dispatch({
            type: "LOGIN_SET_TRUE",
            payload: param
        })
    }
}

export function setFalse(param) {
    return dispatch => {
        dispatch({
            type: "LOGIN_SET_FALSE",
            payload: param
        })
    }
}

export function setValue(details) {
    return dispatch => {
        dispatch({
            type: "LOGIN_SET_VALUE",
            payload: details
        })
    }
}

export function resetLoginData() {
    return dispatch => {
        dispatch({
            type: "LOGIN_SET_INITIAL_STATE",
            payload: null
        })
    }
}
