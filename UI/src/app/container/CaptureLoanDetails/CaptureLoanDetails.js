import React from 'react';
import { InputBox } from '../../common/InputGroup/InputBox';
import { bindActionCreators } from 'redux';
import './CaptureLoanDetails.css';
import { connect } from 'react-redux';
import { updateInput, loanDetails } from '../../actions/loanDetailsActions';

class CaptureLoanDetails extends React.Component {
    updateInput(event) {
        this.props.updateInput(event);
    }

    handleSubmit(e) {
        e.preventDefault();
        debugger;
        let P = this.props.loanReducer.amount;
        let R = 0.00833;
        let n = this.props.loanReducer.tenure;
        let EMI = (P * R * (Math.pow(R, n)))/(Math.pow(R, (n-1)))
        let data = {
            userId: this.props.loginReducer.userId,
            type: 'EDUCATONAL',
            amount: this.props.loanReducer.amount,
            tenure: this.props.loanReducer.tenure,
            interestRate: this.props.loanReducer.interestRate,
            universityName: this.props.loanReducer.university,
            emi: EMI,
        };
        this.props.loanDetails(data);
    }

    render() {
        return (
            <section id='loanRed-section' className='container-fluid'>
                <div className='col-md-6 col-md-offset-3' id="form-div">
                    <form method='POST' onSubmit={(event) => this.handleSubmit(event)}>
                        <h1 className='align-center'>
                            Loan Details Form
                        </h1>

                        <hr />
                        <div className="row no-margin">
                            <div className="col-md-6">
                                <InputBox
                                    value='Education Loan'
                                    label='Loan type:'
                                    name='interestRate'
                                    disabled='disabled' />
                            </div>
                            <div className="col-md-6">
                                <InputBox
                                    value='10%'
                                    label='Interest Rate:'
                                    name='interestRate'
                                    disabled='disabled' />
                            </div>
                        </div>

                        <div className="row no-margin">

                            <div className="col-md-4">

                                <InputBox
                                    required="required"
                                    value={this.props.loanReducer.amount}
                                    label='Amount:'
                                    min='100000'
                                    name='amount'
                                    type='number'
                                    placeholder='Amount(INR)'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>

                            <div className="col-md-4">

                                <InputBox
                                    required="required"
                                    value={this.props.loanReducer.tenure}
                                    label='Tenure:'
                                    name='tenure'
                                    min='6'
                                    max='60'
                                    type='number'
                                    placeholder='Tenure(in months)'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>

                            <div className="col-md-4">
                                <InputBox
                                    required="required"
                                    value={this.props.loanReducer.university}
                                    label='University:'
                                    min='100000'
                                    name='university'
                                    type='text'
                                    placeholder='University Name'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>
                            
                            <div className="row no-margin">
                                <button
                                    className="btn btn-primary col-md-3 col-md-offset-4"
                                    type="submit"
                                >Submit</button>
                            </div>
                            <br />
                        </div>
                    </form>
                </div>
            </section >
        );
    }
}
const mapStateToProps = (_state) => {
    let state = _state;
    return {
        loanReducer: state.loanReducer,
        loginReducer: state.loginReducer,
    };
};

const mapDispatchToProps = (_dispatch) => {
    let dispatch = _dispatch;
    return bindActionCreators({ updateInput, loanDetails }, dispatch);
};

export default connect(mapStateToProps, mapDispatchToProps)(CaptureLoanDetails);
