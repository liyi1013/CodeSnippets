import streamlit as st
import qrcode

title = st.text_input('text', '')
st.write('The current text is', title)

if title:
    img = qrcode.make(title)
    st.image(img.get_image())

