import React from "react";
import './LoanDisbursementDetails.css'
import { Link } from 'react-router'
import { connect } from "react-redux"
import { bindActionCreators } from 'redux';
import { getLoanDetails } from '../../actions/loanDetailsActions';


class LoanDisbursementDetails extends React.Component {
    componentWillMount() {
        this.props.getLoanDetails(this.props.loginReducer.userId)
    }
    render() {
        return (
            <section className="loanDisbursement-section h100 w100">
                <div className="row no-margin">
                    <div className="col-md-12">
                        <table className="table table-bordered table-hover table-responsive table-position">
                            <thead>
                                <tr>
                                    <th>Loan Type</th>
                                    <th>Interest Rate</th>
                                    <th>Amount</th>
                                    <th>Tenure</th>
                                    <th>EMI</th>
                                    <th>Timestamp</th>
                                    <th>Loan Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    (this.props.loanReducer.loansList.length !== 0) ?
                                        (
                                            this.props.loanReducer.loansList.map((details, i) => {
                                                return (
                                                    <tr key={i}>
                                                        <td >EDUCATION LOAN</td>
                                                        <td >10%</td>
                                                        <td >{details.amount}</td>
                                                        <td >{details.tenure}</td>
                                                        <td >{details.emi}</td>
                                                        <td >{details.loanApplyDate}</td>
                                                        <td >{details.loanStatus}</td>
                                                    </tr>
                                                );

                                            })
                                        )
                                        :
                                        (
                                            <tr id='noLoans'>
                                                <td colSpan='7'>
                                                    <div className="col-md-6 col-md-offset-4">
                                                        <h1>No previous loans available</h1>
                                                        <h5 className="col-md-offset-3">
                                                            <Link to="/userHome">Click here</Link> to apply now
                                                        </h5>
                                                    </div>
                                                </td>
                                            </tr>

                                        )
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

        )
    }

};

const mapStateToProps = (state) => {
    return {
        loginReducer: state.loginReducer,
        loanReducer: state.loanReducer,
    }
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators({ getLoanDetails }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(LoanDisbursementDetails);