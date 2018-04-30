import React from 'react';
import { InputBox } from '../../common/InputGroup/InputBox';
import { bindActionCreators } from 'redux';
import './RegistrationPage.css';
import { connect } from 'react-redux';
import { updateInput, userRegistration } from '../../actions/RegistrationActions';

class RegistrationPage extends React.Component {
    updateInput(event) {
        this.props.updateInput(event);
    }

    handleEnroll(e) {
        e.preventDefault();
        let data = {
            firstName: this.props.userRed.firstName,
            middleName: this.props.userRed.middleName,
            lastName: this.props.userRed.lastName,
            dob: this.props.userRed.dob,
            gender: this.props.userRed.gender,
            contactNo: this.props.userRed.mobile,
            emailId: this.props.userRed.email,
            password: this.props.userRed.password,
            addressLine1: this.props.userRed.addressLine1,
            addressLine2: this.props.userRed.addressLine2,
            city: this.props.userRed.city,
            state: this.props.userRed.state,
            pincode: this.props.userRed.pincode,
        };
        this.props.userRegistration(data);
    }

    render() {
        return (
            <section id='sdntRed-section' className='container-fluid'>
                <div className='col-md-12' id="form-div">
                    <form onSubmit={(event) => this.handleEnroll(event)}>
                        <h3 className='align-center'>
                            User Registration Form
                        </h3>

                        <hr />

                        <div className="row no-margin">

                            <div className="col-md-4 no-padding">
                                <InputBox
                                    required="required"
                                    value={this.props.userRed.firstName}
                                    label='First Name:'
                                    name='firstName'
                                    type='text'
                                    placeholder='FirstName'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>

                            <div className="col-md-4 no-padding">
                                <InputBox
                                    value={this.props.userRed.middleName}
                                    label='Middle Name:'
                                    name='middleName'
                                    type='text'
                                    placeholder='MiddleName(optional)'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>

                            <div className="col-md-4 no-padding">
                                <InputBox
                                    required="required"
                                    value={this.props.userRed.lastName}
                                    label='Last Name:'
                                    name='lastName'
                                    type='text'
                                    placeholder='LastName'
                                    onChange={(event) => this.updateInput(event)} />
                            </div>

                        </div>

                        <div className="row no-margin">

                            <InputBox
                                required="required"
                                value={this.props.userRed.dob}
                                label='DOB:'
                                name='dob'
                                type='date'
                                placeholder='Date of Birth'
                                onChange={(event) => this.updateInput(event)} />

                            <div className="row no-margin">

                                <label htmlFor="gender">Gender:</label>
                                <div id="gender-section">
                                    <label htmlFor="male">male</label>
                                    <input
                                        className="radioInput"
                                        checked={this.props.userRed.gender === 'male'}
                                        value='male'
                                        name='gender'
                                        type='radio'
                                        onChange={(event) => this.updateInput(event)} />

                                    <label htmlFor="female">female</label>
                                    <input
                                        className="radioInput"
                                        checked={this.props.userRed.gender === 'female'}
                                        value='female'
                                        name='gender'
                                        type='radio'
                                        onChange={(event) => this.updateInput(event)} />

                                </div>
                            </div>
                            <InputBox
                                required="required"
                                value={this.props.userRed.mobile}
                                label='Mobile:'
                                name='mobile'
                                maxLength='10'
                                minLength='10'
                                type='number'
                                placeholder='mobile'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                required="required"
                                value={this.props.userRed.email}
                                label='Email:'
                                name='email'
                                type='email'
                                placeholder='Email-Id'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                required="required"
                                value={this.props.userRed.password}
                                label='Password:'
                                name='password'
                                type='password'
                                placeholder='Password'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                required="required"
                                value={this.props.userRed.addressLine1}
                                label='Address Line-1:'
                                name='addressLine1'
                                type='text'
                                placeholder='Address:(Line1)'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                value={this.props.userRed.addressLine2}
                                label='Address Line-2:'
                                name='addressLine2'
                                type='text'
                                placeholder='Address:(Line2) (optional)'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                required="required"
                                value={this.props.userRed.city}
                                label='City:'
                                name='city'
                                type='text'
                                placeholder='City Name'
                                onChange={(event) => this.updateInput(event)} />
                            <InputBox
                                required="required"
                                value={this.props.userRed.state}
                                label='State:'
                                name='state'
                                type='text'
                                placeholder='State Name'
                                onChange={(event) => this.updateInput(event)} />

                            <InputBox
                                required="required"
                                value={this.props.userRed.pincode}
                                label='Pincode:'
                                name='pincode'
                                type='number'
                                maxLength='6'
                                minLength='6'
                                placeholder='Pincode'
                                onChange={(event) => this.updateInput(event)} />
                        </div>
                        <div className="row no-margin">
                            <button
                                className="btn btn-primary col-md-3 col-md-offset-4"
                                type="submit"
                            >Register</button>

                        </div>

                        <br />
                    </form>
                </div>
            </section >
        );
    }
}
const mapStateToProps = (_state) => {
    let state = _state;
    return {
        userRed: state.regdReducer,
    };
};

const mapDispatchToProps = (_dispatch) => {
    let dispatch = _dispatch;
    return bindActionCreators({ updateInput, userRegistration }, dispatch);
};

export default connect(mapStateToProps, mapDispatchToProps)(RegistrationPage);