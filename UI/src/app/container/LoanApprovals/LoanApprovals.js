import React from "react";
import './LoanApprovals.css'
import { Link } from 'react-router'
import { connect } from "react-redux"
import { bindActionCreators } from 'redux';
import { getLoanApprovals } from '../../actions/adminActions';


class LoanApprovals extends React.Component {
    componentWillMount() {
        this.props.getLoanApprovals();
    }
    render() {
        return (
            <section className="LoanApprovals-section h100 w100">
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
                                    <th>Approve/Reject</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    (this.props.adminReducer.loanDetails.length !== 0) ?
                                        (
                                            this.props.adminReducer.loanDetails.map((details, i) => {
                                                return (
                                                    <tr value={self.selectedTrade} name="selectedTrade" onClick={() => self.onTradeSelected(details)} key={i}>
                                                        <td >{details.assetId}</td>
                                                        <td >{details.assetType}</td>
                                                        <td >{details.type}</td>
                                                        <td >{details.tradedAmount}</td>
                                                        <td >{details.tradedTime.toLocaleString()}</td>
                                                    </tr>
                                                );

                                            })
                                        )
                                        :
                                        (
                                            <tr id='noLoans'>
                                                <td colSpan='8'>
                                                    <div className="col-md-6 col-md-offset-4">
                                                        <h1>No loan requests available</h1>
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
        adminReducer: state.adminReducer
    }
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators({ getLoanApprovals }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(LoanApprovals);