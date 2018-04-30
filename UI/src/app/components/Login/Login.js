import React from 'react';
import './Login.css';
import { InputBox } from '../../common/InputGroup/InputBox';

export const Login = (_props) => {
    let props = _props;
    return (
        <div>
            <form method='POST' id='login-box' onSubmit={(event) => event.preventDefault()}>
                
                <div className="row no-margin">
                    <div className="col-md-12">
                    <h3>Login:</h3>
                        <InputBox
                            required="required"
                            label='Email:'
                            value={props.loginReducer.userId}
                            name='userId'
                            type='email'
                            placeholder='ex:User123@gmail.com'
                            onChange={(event) => props.updateInput(event)} />
                        <InputBox
                            required="required"
                            value={props.loginReducer.password}
                            label='Password:'
                            name='password'
                            type='password'
                            placeholder='Enter Password'
                            onChange={(event) => props.updateInput(event)} />
                        <button
                            onClick={() => props.handleLogin()}
                            className='btn btn-primary'>
                            Login
                    </button>
                    </div>
                </div>
            </form>
        </div>
    );
}
