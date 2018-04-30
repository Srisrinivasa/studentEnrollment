import axios from 'axios';
import { browserHistory } from 'react-router';

export const updateInput = (event) => {
  return {
    type: 'LOAN_UPDATE_INPUT',
    payload: event.target,
  };
};

export const getLoanDetails = (userId) => {

    return dispatch => {
        debugger;
        axios({
            method: 'GET',
            url: 'http://10.117.189.233:8080/loan/details',
            headers: {
                userId: userId
            },
        })
            .then((response) => {
                debugger;
                if (response.status === 200) {
                    dispatch({
                      type: 'LOAN_SET_VALUE',
                      payload: {id:'loansList', val:response.data}
                    });
                }
                else {
                    alert('Something went wrong in fetching data');
                }
            })
    };
};

export const loanDetails = (details) => {

  return dispatch => {
    axios({
      method: 'POST',
      url: 'http://10.117.189.233:8080/loan/captureDetails',
      data: details,
    })
      .then((response) => {
        if (response.status === 201) {
          alert(response.data);
          browserHistory.push('/loanStatus');
        }
        else {
          alert('Something went wrong \n Please try again later');
        }
      })
  };
};

export function setValue(details) {
  return dispatch => {
    dispatch({
      type: "LOAN_SET_VALUE",
      payload: details
    })
  }
}
