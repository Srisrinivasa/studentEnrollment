import React from 'react';
import { connect } from 'react-redux';
import NavigionBar from '../../components/NavigationBar/NavigationBar';
import { Link } from 'react-router';

class UserHome extends React.Component {
    render() {
        return (
            <section className='userHome-section h100 w100'>
                {
                    (this.props.role === 'USER') ?
                        (
                            <div>
                                <NavigionBar />
                                {this.props.children}
                            </div>
                        )
                        :
                        (
                            <div className="col-md-4 col-md-offset-4">
                                <h1>Oops!!! Session Expired</h1>
                                <h5 className="col-md-offset-3">
                                    <Link to="/">Click here</Link> to Login again
                                </h5>
                            </div>
                        )
                }
            </section>
        )
    }
}

const mapStateToProps = (_state) => {
    let state = _state;
    return {
        role: state.loginReducer.role,
    };
};

export default connect(mapStateToProps)(UserHome);