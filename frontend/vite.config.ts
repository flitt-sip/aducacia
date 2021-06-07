import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],

    // server: {
    //     proxy: {
    //         // string shorthand
    //         '/pups': 'http://localhost:8081'
    //     }
    // }
})
