import { useContext } from 'react';
import style from './closeOrder.module.scss';
import { BtnEnviarPedido } from '../../components';
import { MyGlobalContext } from '../context/GlobalContext';

export function CloseOrder() {

    const { totalPrice, produtos } = useContext(MyGlobalContext);
    
    return (
        <div className={style.closeOrder}>
            <div className={style.sideLeft}>
                <div className={style.orderQuantiy}>
                    <span><strong>{produtos}</strong> PRODUTO(S) SELECIONADO(S)</span>
                </div>
                <div className={style.priceTotal}>
                    <span><strong>R$ {Math.round(totalPrice *100)/100}</strong> VALOR TOTAL</span>
                </div>
            </div>
            <div className={style.sideRight}>
                <BtnEnviarPedido />
            </div>
        </div>
    )
}