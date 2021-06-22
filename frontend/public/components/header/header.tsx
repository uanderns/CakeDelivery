import styles from './header.module.scss';
import { Menu } from '../index';
import { useRouter } from 'next/router';
import { routerEnum } from '../../enum/enum';
import { useState, useEffect } from 'react';

export function Header() {

    const router = useRouter();

    const [isLogin, setIsLogin] = useState(false);
    const [URL] = useState(router.pathname);

    useEffect(() => {
        const changeURL = () => {
            if (URL == "/") {
                setIsLogin(true);
            }
        }

        changeURL();

    }, []);

    return (
        <div className={styles.header}>
            <div className={styles.logo}>
                <div className={styles.icon}></div>
                <div className={styles.title}>
                    <span>CakeDelivery</span>
                </div>
            </div>
            {
                !isLogin &&
                <>
                    <div className={styles.menu}>
                        <Menu />
                    </div>
                    <div className={styles.logout}>
                        <div className={styles.icon} onClick={() => router.push(routerEnum.LOGIN)}></div>
                    </div>
                </>
            }
        </div>
    )
}