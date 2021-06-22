import styles from './menu.module.scss';
import { useRouter } from 'next/router';
import { routerEnum } from '../../enum/enum';
import { MyGlobalContext } from '../context/GlobalContext';
import { useContext, useState, useEffect } from 'react';


export function Menu() {

    const router = useRouter();

    const { setShowModalProduto, setShowModalSabor, setShowModalTipo, setShowModalTamanho } = useContext(MyGlobalContext);
    const [URL, setURL] = useState(router.pathname);

    useEffect(() => {
        const changeURL = () => {
            setURL(router.pathname);
        }
        changeURL();
    }, []);

    const clickEventBolo = () => {
        setShowModalProduto(true);
    }

    const clickEventSabor = () => {
        setShowModalSabor(true);
    }

    const clickEventTipo = () => {
        setShowModalTipo(true);
    }

    const clickEventTamanho = () => {
        setShowModalTamanho(true);
    }

    return (
        <div className={styles.menu}>
            <ul>
                {
                    URL == `/${routerEnum.CARDAPIO}` &&
                    <>
                        <li onClick={clickEventBolo}>Cadastrar Bolo</li>
                        <li onClick={clickEventSabor}>Cadastrar Sabor</li>
                        <li onClick={clickEventTipo}>Cadastrar Tipo</li>
                        <li onClick={clickEventTamanho}>Cadastrar Tamanho</li>
                    </>
                }


                <li onClick={() => router.push(routerEnum.CARDAPIO)}>Cardápio</li>
                <li onClick={() => router.push(routerEnum.LISTA_PEDIDOS)}>Lista de Pedidos</li>
            </ul>
        </div>
    )
}