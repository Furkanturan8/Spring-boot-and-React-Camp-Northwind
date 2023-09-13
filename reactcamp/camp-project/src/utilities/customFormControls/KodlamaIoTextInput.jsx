import { useField } from 'formik'
import React from 'react'
import { FormField,Label } from 'semantic-ui-react'

export default function KodlamaIoTextInput({...props}) {
    //console.log(props)
    const [field,meta] = useField(props) // formik props la gelen verinin name ine bakıp onun bilgilerini yakalıyor(arka planda reflect api kullanıyor) 
    
    // console.log(meta) // meta da bize hata var mı yok mu onu bildiriyor

    return (
        <FormField error={meta.touched && !!meta.error}> 
            <input {...field} {...props}/> 
            {meta.touched && !!meta.error ? (
                <Label pointing basic color='red' content={meta.error}></Label>
            ):null}
        </FormField>
  )
}
