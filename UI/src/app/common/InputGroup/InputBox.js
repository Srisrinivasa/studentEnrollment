import React from 'react';
import classnames from 'classnames';
import './InputBox.css';

export const InputBox = (props) => {
    let {
        name,
        label,
        type,
        value,
        placeholder, onChange, errors, required, className, checked, disabled, min,
        max,
        minLength,
        maxLength,
     }
        = props;
    return (
        <div className='form-group'>
            <div>
                {label && <label htmlFor={name}>{label}</label>}
                <input type={type}
                    disabled={disabled}
                    required={required}
                    value={value}
                    min={min}
                    max={max}
                    minLength={minLength}
                    maxLength={maxLength}
                    checked={checked}
                    name={name}
                    className={classnames('form-control', { 'hasError': errors }, className)}
                    placeholder={placeholder}
                    onChange={onChange} />
                {errors && <span className='errorMsg'>{errors}</span>}
            </div>
        </div>
    );
};
