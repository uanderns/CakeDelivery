import style from './filter.module.scss';
import { BtnFiltrar } from '../../components';

export function Filter() {
    return (
        <div className={style.filter}>
            <div className={style.sideLeft}>
                <input type={'text'} placeholder={'Nome do produto'} />
            </div>
            <div className={style.sideRight}>
                <BtnFiltrar />
            </div>
        </div>
    )
}