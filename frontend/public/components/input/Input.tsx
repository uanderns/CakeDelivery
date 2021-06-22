import styles from './input.module.scss';

type IInput = {
    type: string,
    placeholder?: string;
    size?: string;
}

export function Input({ ...props }: IInput) {
    return <input type={props.type} placeholder={props.placeholder} className={`${styles.input} ${styles[`${props.size}`]}`} />
}