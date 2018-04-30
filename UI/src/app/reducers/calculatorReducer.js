import * as initialStates from '../common/InitialStates';

const calculatorReducer = (state = initialStates.calculator, action) => {
  switch (action.type) {
    case 'CAL_UPDATE_INPUT':
      state = {
        ...state,
        [action.payload.name]: action.payload.value,
      };
      break;
  };
  return state;
};

export default calculatorReducer;