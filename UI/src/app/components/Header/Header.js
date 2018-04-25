export const Header = (_props) => {
    let props = _props;
    return (
        <div className='row no-margin'>
            <h1>{props.titleName}</h1>
        </div>
    );
}
