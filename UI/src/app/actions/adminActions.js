import axios from 'axios';

export const getUserDetails = () => {

    return dispatch => {
        debugger;
        axios({
            method: 'GET',
            url: 'http://10.117.189.233:8080/user/pendingKycUsers',
        })
            .then((response) => {
                debugger;
                if (response.status === 200) {
                    dispatch({
                        type: 'ADMIN_SET_VALUE',
                        payload: { id: 'userDetails', val: response.data }
                    });
                }
                else {
                    alert('Something went wrong \n Please try again later');
                }
            })
    };
};
export const updateKYCStatus = (id, status) => {

    return dispatch => {
        debugger;
        axios({
            method: 'POST',
            url: 'http://10.117.189.233:8080/user/updateKycStatus',
            data: {
                kycStatus: status,
                id: id,
            }
        })
            .then((response) => {
                debugger;
                if (response.status === 200) {
                    alert('Action succeded');
                }
                else {
                    alert('Something went wrong \n Please try again later');
                }
            })
    };
};
export const getLoanApprovals = () => {

    return dispatch => {
        debugger;
        axios({
            method: 'GET',
            url: 'http://10.117.189.233:8080/loan/details',
            headers: {
                userId: null
            },
        })
            .then((response) => {
                if (response.status === 200) {
                    dispatch({
                        type: 'ADMIN_SET_VALUE',
                        payload: { id: 'loanDetails', val: response.data }
                    });
                }
                else {
                    alert('Something went wrong in fetching data');
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
