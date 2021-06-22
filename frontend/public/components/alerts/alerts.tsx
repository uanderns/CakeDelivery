import { useEffect, useContext } from 'react';
import style from './alerts.module.scss';
import { MyGlobalContext } from '../context/GlobalContext';

export function Alerts() {

    const { isVisible, setIsVisible, alertMsg, typeAlert, setTypeAlert } = useContext(MyGlobalContext);

    useEffect(() => {
        if (isVisible) {
            setTimeout(() => {
                setIsVisible(false);
                setTypeAlert('default');
            }, 3000)
        }
    }, [isVisible])

    return (
        <>
            {
                isVisible &&
                < div className={`${style.alerts} ${style[`${typeAlert}`]}`} >
                    <span>{alertMsg}</span>
                </div >
            }
        </>
    )
}