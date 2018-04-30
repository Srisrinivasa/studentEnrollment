import * as initialStates from '../common/InitialStates';

const loanReducer = (state = initialStates.loanDetails, action) => {
    switch (action.type) {
        case 'LOAN_UPDATE_INPUT':
        state = {
          ...state,
          [action.payload.name]: action.payload.value,
        };
        break;
        case 'LOAN_SET_VALUE':
        state = {
          ...state,
          [action.payload.id]: action.payload.val,
        };
        break;
      case 'LOAN_DETAIL_FULFILLED':
        state = {
          ...state,
          pending: false,
        };
        break;
      case 'LOAN_DETAIL_REJECTED':
        state = {
          ...state,
          pending: false,
        };
        break;
      case 'LOAN_DETAIL_PENDING':
        state = {
          ...state,
          pending: true,
        };
        break;
    }
    return state;
}
export default loanReducer;

