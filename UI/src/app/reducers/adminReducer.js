import * as initialStates from '../common/InitialStates';

const adminReducer = (state = initialStates.admin, action) => {
  switch (action.type) {
   case 'ADMIN_SET_VALUE':
        state = {
          ...state,
          [action.payload.id]: action.payload.val,
        };
        break;
  };
  return state;
};

export default adminReducer;