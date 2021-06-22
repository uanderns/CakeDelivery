import style from './buttons.module.scss';
import { useRouter } from 'next/router';
import { routerEnum } from '../../enum/enum';
import { MyGlobalContext } from '../context/GlobalContext';
import { useContext } from 'react';

export function BtnEnviarPedido() {
    return (
        <div className={style.btnEnviarPedido}>
            <span>Enviar pedido</span>
        </div>
    )
}

export function BtnFiltrar() {
    return (
        <div className={style.btnFiltrar}>
            <span>Filtrar</span>
        </div>
    )
}

export function BtnLogar() {
    const router = useRouter();

    const clickEvent = (e) => {
        e.preventDefault();
        router.push(routerEnum.CARDAPIO);
    }

    return (
        <div className={style.btnLogar} onClick={(e) => clickEvent(e)}>
            <span>Logar</span>
        </div>
    )
}

export function BtnCadastrar() {

    const { setIsVisible, setAlertMsg, setTypeAlert } = useContext(MyGlobalContext);

    const clickEvent = (e) => {
        e.preventDefault();
        setIsVisible(true);
        setAlertMsg('Cadastrado com sucesso');
        setTypeAlert('success');
    }

    return (
        <div className={style.btnCadastrar} onClick={(e) => clickEvent(e)}>
            <span>Cadastrar</span>
        </div>
    )
}