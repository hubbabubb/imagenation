import {ReactComponent as Svg} from "../../images/svgs/regular/sun.svg";
import {makeStyles} from "@material-ui/core";

const useStyles = makeStyles(theme => ({
    root: {
        width: 200,

    },
    svg: {
        strokeWidth: 5,
        stroke: "black",
        fill: "purple",
        animation: `$anim .2s ease-in-out`,
        transition: "color 1s",
        '&:hover': {
            fill: "#f00",
        },
    },
    '@keyFrames anim': {
        "0%": {
            opacity: 0,
            transform: "translateY(-200%)"
        },
        "100%": {
            opacity: 1,
            transform: "translateY(0)"
        }
    },
}));

export default function Display(props) {
    let theme = useStyles();

    return <div className={theme.root}>
        <div>
            <Svg className={theme.svg}/>
        </div>
    </div>
}