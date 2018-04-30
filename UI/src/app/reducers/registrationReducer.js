import * as initialStates from '../common/InitialStates';

const registrationReducer = (state = initialStates.userEnroll, action) => {
  switch (action.type) {
    case 'UPDATE_INPUT':
      state = {
        ...state,
        [action.payload.name]: action.payload.value,
      };
      break;
    case 'ENROLL_USER_FULFILLED':
      state = {
        ...state,
        pending: false,
      };
      break;
    case 'ENROLL_USER_REJECTED':
      state = {
        ...state,
        pending: false,
      };
      break;
    case 'ENROLL_USER_PENDING':
      state = {
        ...state,
        pending: true,
      };
      break;

  };
  return state;
};

export default registrationReducer;