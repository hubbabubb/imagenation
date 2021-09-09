import React from 'react';

class ReactSvg extends React.Component {
    render() {
        console.log(this.props.svg);
        return (
            <div>
                {this.props.svg}
            </div>
        )
    }
}

export default ReactSvg;