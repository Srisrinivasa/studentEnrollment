import { InputBox } from '../../common/InputGroup/InputBox';
import React from 'react';
import './EMICalculator.css';

export default class EMICalculator extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            amount: 0,
            tenure: 6,
            EMI:0
        }
    }
    calculateEMI() {
        let P = this.state.amount;
        let n = this.state.tenure;
        const R = 1.00833;

        const EMI = (P * R * (Math.pow(R, n)))/(Math.pow(R, (n-1)))
        
        this.setState({
            EMI: EMI
        });
    }
    updateInput(event) {
        this.setState({
            [event.target.name]: event.target.value,
        });
        this.calculateEMI();
    }
    render() {
        return (
            <section id='calculator-section' className='container-fluid'>
                <div className='row no-margin' id="form-div">
                    <form className='col-md-12'>
                        <h1 className='align-center'>
                            EMI Calculator
                       </h1>
                        <hr />
                        <InputBox
                            required="required"
                            value='10%'
                            disabled='disabled'
                            label='Rate of Interest:'
                        />
                        <div className="row no-margin">

                            <div className="col-md-6">
                                <InputBox
                                    required="required"
                                    value={this.state.amount}
                                    label='Amount:'
                                    min='0'
                                    name='amount'
                                    type='number'
                                    placeholder='Amount(INR)'
                                    onChange={(event) => this.updateInput(event)}
                                />
                            </div>

                            <div className="col-md-6">
                                <InputBox
                                    value={this.state.tenure}
                                    label='Tenure:'
                                    name='tenure'
                                    min='6'
                                    type='number'
                                    placeholder='Tenure( in months)'
                                    onChange={(event) => this.updateInput(event)}
                                />
                            </div>

                        </div>
                        <div className='col-md-offset-5'>
                            <label htmlFor="EMIOutput">EMI:</label>
                            <output id='EMIOutput'>
                               {this.state.EMI}
                            </output>
                        </div>
                        <br />
                    </form>
                </div>
            </section >
        );
    }
}