import React, {useState} from "react";
import styled from "styled-components";
import InlineSVG from 'svg-inline-react';
import {Button, ButtonGroup, makeStyles} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
        width: "100%",
        position: "relative",
        height: "100%",
        display: "flex",
        alignItems: "center",
        justifyContent: "center"

    },
    buttons: {
        position: 'absolute',
        display: "block",
        left: 10,
        top: 10,
    },
}));

const CssDisplay = styled.div`
    text-align: left;
    color: #e5e2de;
    padding: 100px 0 0 50px;
    font-family: 'Monaco';
    width: 100%;
    height: 100%;
    background-color: black;
`;

export default function Display(props) {
    const [display, setDisplay] = useState("display")
    const classes = useStyles();
    const Theme = styled.div`
    svg {
       width: ${(props.theme.size) + "px"};
       fill: ${props.theme.color};
       stroke: ${props.theme.borderColor};
       stroke-width: ${props.theme.borderWidth + "px"}; 
       } 
    `;

    const svgText = "svg {";
    return <div className={classes.root}>
        <ButtonGroup className={classes.buttons} size="small" aria-label="small outlined button group">
            <Button onClick={() => {setDisplay("display")}} color="primary">Display</Button>
            <Button onClick={() => {setDisplay("css")}} color="secondary">CSS</Button>
        </ButtonGroup>
        {display === "display" ?
            <Theme> <InlineSVG src={props.theme.objectFile}/> </Theme>
            :
            <CssDisplay>
                <p>{svgText}</p>
                <p>&nbsp; &nbsp; width: {props.theme.size}px;</p>
                <p>&nbsp; &nbsp; fill: {props.theme.color};</p>
                <p>&nbsp; &nbsp; stroke: {props.theme.borderColor};</p>
                <p>&nbsp; &nbsp; stroke-width: {props.theme.borderWidth}px;</p>
                <p>}</p>
            </CssDisplay>
        }
    </div>

}