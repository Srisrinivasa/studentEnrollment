import React from "react";
import './KYCApprovals.css';
import { Link } from 'react-router';
import { connect } from "react-redux";
import { bindActionCreators } from 'redux';
import { getUserDetails, updateKYCStatus } from '../../actions/adminActions';


class KYCApprovals extends React.Component {
    componentWillMount() {
        this.props.getUserDetails()
    }
    componentWillReceiveProps(nextProps) {
        (this.props.adminReducer.userDetails.length !== nextProps.adminReducer.userDetails.length) &&  this.props.getUserDetails()
    }
    render() {
        return (
            <section className="KYCApprovals-section h100 w100">
                <div className="row no-margin">
                    <div className="col-md-12">
                        <table className="table table-bordered table-hover table-responsive table-position">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Address</th>
                                    <th>DOB</th>
                                    <th>Gender</th>
                                    <th>Contact No</th>
                                    <th>Email</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Pincode</th>
                                    <th>Approve/Reject</th>
                                </tr>
                            </thead>
                            <tbody>

                                {
                                    (this.props.adminReducer.userDetails.length !== 0) ?
                                        (
                                            this.props.adminReducer.userDetails.reverse().map((details, i) => {
                                                return (
                                                    <tr key={i}>

                                                        <td >{details.firstName}</td>
                                                        <td >{details.lastName}</td>
                                                        <td >{details.addressLine1}</td>
                                                        <td >{details.dob}</td>
                                                        <td >{details.gender}</td>
                                                        <td >{details.contactNo}</td>
                                                        <td >{details.emailId}</td>
                                                        <td >{details.city}</td>
                                                        <td >{details.pincode}</td>
                                                        <td >{details.state}</td>
                                                        <td >
                                                            <button
                                                                onClick={() => this.props.updateKYCStatus(details.id, 'APPROVED')}
                                                                className="btn-xs btn-success">
                                                                <i className="fa fa-check" />
                                                                Approve
                                                   </button>
                                                            <button
                                                                onClick={() => this.props.updateKYCStatus(details.id, 'REJECTED')}
                                                                className="btn-xs col-md-offset-1">
                                                                <i className="fa fa-remove" />
                                                                Reject
                                                   </button>
                                                        </td>
                                                    </tr>
                                                );

                                            })
                                        )
                                        :
                                        (
                                            <tr id='noLoans'>
                                                <td colSpan='11'>
                                                    <div className="col-md-6 col-md-offset-4">
                                                        <h1>No requests available</h1>
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
        adminReducer: state.adminReducer,
    }
}

function mapDispatchToProps(dispatch) {
    return bindActionCreators({ getUserDetails, updateKYCStatus }, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(KYCApprovals);