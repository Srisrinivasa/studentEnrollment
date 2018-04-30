import axios from 'axios';

export const updateInput = (event) => {
  return {
    type: 'UPDATE_INPUT',
    payload: event.target,
  };
};

export const userRegistration = (details) => {

  return dispatch => {
    return axios({
      method: 'POST',
      url: 'http://10.117.189.233:8080/user/register',
      data: details,
    })
      .then((response) => {
        if (response.status === 201) {
          alert('Registration successful \n Submitted for Approval \n You will be notified once approved');
        }
        else if (response.status === 400) {
          alert('Registration Request already submitted');
        }
        else {
          alert('Oops!!! Something went wrong /n Please try after sometime');
        }
      })
  };
};
